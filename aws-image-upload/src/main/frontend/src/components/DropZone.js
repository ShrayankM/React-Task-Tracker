import axios from 'axios';
import React, { useCallback } from 'react'
import { useDropzone } from 'react-dropzone'

const DropZone = ( {id} ) => {
    const onDrop = useCallback(acceptedFiles => {
       
        const formData = new FormData();
        formData.append("file", acceptedFiles[0]);

        axios.post(`http://localhost:8080/api/v1/user-profile/${id}/image/upload`, formData, {
            headers: {
                "Content-Type" : "multipart/form-data"
            }
        }).then(() => {
            console.log("User-profile uploaded successfully");
        }).catch((error) => {
            console.log(error);
        });
    }, [id])

    const {getRootProps, getInputProps, isDragActive} = useDropzone({onDrop})

  return (
    <div {...getRootProps()}>
      <input {...getInputProps()} />
      {
        isDragActive ?
          <p>Drop the files here ...</p> :
          <p>Drag 'n' drop profile image, or click to select profile image</p>
      }
    </div>
  )
}

export default DropZone