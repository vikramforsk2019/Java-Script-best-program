<html>
   <head>
      <title>File Uploading Form</title>
   </head>
   
   <body>
      <h3>File Upload:</h3>
      Select a file to upload: <br />
      <form action = "Ved" method = "post"
         enctype = "multipart/form-data">
         <input type = "file" name = "file" size = "50" />
         <input type="text" name="t1"/>
         <br />
         <input type = "submit" value = "Upload File" />
      </form>
   </body>
   
</html>