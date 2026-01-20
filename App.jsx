// import React, { useState } from "react";

// function App() {
//   const [name, setName] = useState("");
//   const [email, setEmail] = useState("");
//   const [age, setAge] = useState("");

//   const handleSubmit = async (e) => {
//     e.preventDefault();

//     // Basic validation
//     if (!name || !email || !age) {
//       alert("All fields are required");
//       return;
//     }

//     const studentData = {
//       name: name.trim(),
//       email: email.trim(),
//       age: parseInt(age, 10),
//     };

//     try {
//       const response = await fetch("http://localhost:4444/api/students", {
//         method: "POST",
//         headers: {
//           "Content-Type": "application/json",
//         },
//         body: JSON.stringify(studentData),
//       });

//       if (!response.ok) {
//         const text = await response.text();
//         throw new Error(text || "API Error");
//       }

//       alert("Student saved successfully!");
//       setName("");
//       setEmail("");
//       setAge("");
//     } catch (error) {
//       console.error("API ERROR:", error);
//       alert("Cannot connect to backend. Make sure Spring Boot is running.");
//     }
//   };

//   return (
//     <div style={{ padding: "20px" }}>
//       <h2>Student Registration</h2>

//       <form onSubmit={handleSubmit}>
//         <input
//           type="text"
//           placeholder="Name"
//           value={name}
//           onChange={(e) => setName(e.target.value)}
//         />
//         <br /><br />

//         <input
//           type="email"
//           placeholder="Email"
//           value={email}
//           onChange={(e) => setEmail(e.target.value)}
//         />
//         <br /><br />

//         <input
//           type="number"
//           placeholder="Age"
//           value={age}
//           onChange={(e) => setAge(e.target.value)}
//         />
//         <br /><br />

//         <button type="submit">Submit</button>
//       </form>
//     </div>
//   );
// }

// export default App;

import React, { useState, useEffect } from "react";
import axios from "axios";

// ✅ FIXED BASE URL
axios.defaults.baseURL = "http://localhost:4444";

function App() {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [age, setAge] = useState("");
  const [students, setStudents] = useState([]);

  const fetchStudents = async () => {
    const res = await axios.get("/students");
    setStudents(res.data);
  };

  useEffect(() => {
  
  }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();
    await axios.post("/students", {
      name,
      email,
      age: Number(age),
    });

    setName("");
    setEmail("");
    setAge("");
    fetchStudents();
  };

  return (
    <div>
      <h1>Student Registration</h1>

      <form onSubmit={handleSubmit}>
        <input placeholder="Name" value={name} onChange={e => setName(e.target.value)} />
        <br />
        <input placeholder="Email" value={email} onChange={e => setEmail(e.target.value)} />
        <br />
        <input placeholder="Age" value={age} onChange={e => setAge(e.target.value)} />
        <br />
        <button type="submit">Save</button>
      </form>

      <h2>Students</h2>
      <table border="1">
        <thead>
          <tr>
            <th>Name</th><th>Email</th><th>Age</th>
          </tr>
        </thead>
        <tbody>
          {students.map(s => (
            <tr key={s.id}>
              <td>{s.name}</td>
              <td>{s.email}</td>
              <td>{s.age}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default App;
