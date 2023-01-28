import { useState } from 'react'
import Header from './components/Header'
import Tasks from './components/Tasks'

function App() {
  const [tasks, setTasks] = useState(
    [{
      id: 1,
      text: 'Doctors Appointment' ,
      day: 'Feb 5th at 2.30pm',
      remainder: true,
    },
    {
      id: 2,
      text: 'Meeting at School',
      day: 'Feb 6th at 1.30pm',
      remainder: true,
    },
    {
      id: 3,
      text: 'Food Shopping',
      day: 'Feb 5th at 2.30pm',
      remainder: false,
    }]);
  
  //TODO Delete task functionality  
  const deleteTask = (id) => {
    setTasks(tasks.filter((task) => task.id !== id));
  }

  //TODO Toggle Remainder on Double Click
  const toggleRemainder = (id) => {
    setTasks(tasks.map((task) => task.id === id ? {...task, remainder: !task.remainder} : task));
  }

  return (
    <div className = "container">
      <Header/>
      {tasks.length > 0 ? <Tasks tasks = {tasks} onDelete = {deleteTask} onToggle = {toggleRemainder} /> : 'No Tasks To Show'}
    </div>
  );
}

export default App;
