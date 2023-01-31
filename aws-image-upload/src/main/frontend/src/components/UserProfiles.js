import { useState, useEffect } from 'react';
import axios from  'axios';
import DropZone from './DropZone';

const UserProfiles = () => {
  const [userProfiles, setUserProfiles] = useState([]);

  const fetchUserProfiles = () => {
    axios.get('http://localhost:8080/api/v1/user-profile').then((response) => {
      // console.log(response.data);
      setUserProfiles(response.data);
    });
  };

  useEffect(() => {
    fetchUserProfiles();
  });

  return userProfiles.map((userProfile, index) => {
    return (
      <div key = {index}>
        <br/>
        <br/>
        <h1> {userProfile.userName} </h1>
        <p> {userProfile.userProfileId} </p>
        <DropZone id = {userProfile.userProfileId} />
        <br/>
      </div>
    )
  });

};

export default UserProfiles