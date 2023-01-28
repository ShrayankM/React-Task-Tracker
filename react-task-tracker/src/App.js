import { useState, useEffect } from 'react'
import Header from './components/Header'
import Tasks from './components/Tasks'
import AddTask from './components/AddTask'

function App() {
  const [showAddTask, setShowAddTask] = useState(false)
  const [tasks, setTasks] = useState([]);

  useEffect(() => {
    const getTasks = async () => {
      const tasksFromServer = await fetchTasks();
      setTasks(tasksFromServer);
    }
    getTasks()
  }, []);
  

  //TODO Fetch tasks data from server
  const fetchTasks = async () => {
    const response = await fetch('http://localhost:5000/tasks');
    const data = await response.json();

    return data;
  }

  //TODO Fetch single task from server
  const fetchTask = async (id) => {
    const response = await fetch(`http://localhost:5000/tasks/${id}`);
    const data = await response.json();

    return data;
  }

  //TODO Add task
  const addTask = async (task) => {
    const response = await fetch('http://localhost:5000/tasks', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(task)
    });
    
    const newTask = await response.json()
    setTasks([...tasks, newTask]);

    // const id = Math.floor(Math.random() * 10) + 1;
    // const newTask = {id, ...task}
  }  
  
  //TODO Delete task functionality  
  const deleteTask = async (id) => {
    await fetch(`http://localhost:5000/tasks/${id}`, { method: 'DELETE' });

    setTasks(tasks.filter((task) => task.id !== id));
  }

  //TODO Toggle Remainder on Double Click on check
  const toggleRemainder = async (id) => {
    const taskToToggle = await fetchTask(id);
    const updatedTask = {...taskToToggle, remainder: !taskToToggle.remainder}

    const response = await fetch(`http://localhost:5000/tasks/${id}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(updatedTask)
    });

    const data = await response.json();

    setTasks(tasks.map((task) => task.id === id ? {...task, remainder: !data.remainder} : task));
  }

  return (
    <div className = "container">
      <Header onAdd = {() => (setShowAddTask(!showAddTask))} showAdd = {showAddTask} />
      {showAddTask ? <AddTask onAdd = {addTask} /> : ''}
      {tasks.length > 0 ? <Tasks tasks = {tasks} onDelete = {deleteTask} onToggle = {toggleRemainder} /> : 'No Tasks To Show'}
    </div>
  );
}

export default App;
