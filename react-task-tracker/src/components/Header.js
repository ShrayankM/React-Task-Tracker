import PropTypes from "prop-types";
import Button from "./Button"

const Header = (props) => {
  const onClick = () => {
    console.log("Clicking button");
  }
    
  return (
    <header className = 'header'>
        <h1> {props.title} </h1>
        <Button color = 'green' text = 'Add' onClick = {onClick} />
    </header>
  )
}

Header.defaultProps = {
    title: 'Task Tracker',
}

//* Types for Properties
Header.propTypes = {
    title: PropTypes.string.isRequired,
}

export default Header;