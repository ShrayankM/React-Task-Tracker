import { useState } from 'react'

const AddTask = ({ onAdd }) => {
  const [text, setText] = useState('')
  const [day, setDay] = useState('')
  const [remainder, setRemainder] = useState(false)

  const onSubmit = (e) => {
    e.preventDefault()

    if (!text) {
        alert('Please enter a task name')
        return
    }

    onAdd({text, day, remainder})

    setText('')
    setDay('')
    setRemainder(false)
  }
    
  return (
    <form className = 'add-form' onSubmit = {onSubmit}>
        <div className = 'form-control'>
            <label> Task </label>
            <input type = 'text' placeholder = 'Task Name' value = {text} 
            onChange ={(e) => (setText(e.target.value))} />
        </div>

        <div className = 'form-control'>
            <label> Day & Time </label>
            <input type = 'text' placeholder = 'Day & Time' value = {day} 
            onChange = {(e) => (setDay(e.target.value))} />
        </div>

        <div className = 'form-control form-control-check'>
            <label> Set Remainder </label>
            <input type = 'checkbox' value = {remainder}
            checked = {remainder}
            onChange = {(e) => (setRemainder(e.currentTarget.checked))} />
        </div>

        <input type = 'submit' className = 'btn btn-block' value = 'Save Task' />
    </form>
  )
}

export default AddTask