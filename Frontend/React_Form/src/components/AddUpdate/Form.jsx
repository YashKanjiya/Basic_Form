import React,{useState,useMemo,useCallback} from 'react'
import CloudUploadIcon from '@mui/icons-material/CloudUpload';
import InfoIcon from '@mui/icons-material/Info';

import { IconButton, Input, InputAdornment } from '@mui/material';
import { AttachFile } from '@mui/icons-material';

import axios from 'axios';

// import { Editor, EditorState, RichUtils } from 'draft-js';
// import 'draft-js/dist/Draft.css';
import { useNavigate } from 'react-router-dom';

import SaveIcon from '@mui/icons-material/Save';
import MenuIcon from '@mui/icons-material/Menu';
import Button from '@mui/material/Button';

import Buttonicon from './Buttonicon';

import ReactQuill from 'react-quill';
import 'react-quill/dist/quill.snow.css';


export const Form = (props) => {

  //Navigate List
  const navigate = useNavigate();
  const[gotolist,setgotolist]=useState(false);

  
  if(gotolist){
    return navigate("/");
  }

  //usestate data

  const[user,setuser]=useState({
    Title:"",
    Authors:"",
    PublicUrl:"",
    ArticleDate:"",
    AccessCategory:"",
    FreeViewExpiry:"",
    Description:"",
    Featureimage:"",
    Pdfimg:"",
  })

  const{Title,Authors,PublicUrl,ArticleDate,AccessCategory,FreeViewExpiry,Description,Featureimage,Pdfimg}=user;
  const onInputChange=(e)=>{
    setuser({...user,[e.target.name]:e.target.value});
  }

  const onSubmit = async (e) =>{
    e.preventDefault();
    await axios.post("http://localhost:9898/user/txn_master",user);
    navigate("/");
  }

  

  //image 
  const [selectedFile, setSelectedFile] = useState(null);

  const [PDFFile, setPDFFile] = useState(null);

  const flag=props.flag;
  console.log(flag);
  //rich text editer
  // const [editorState, setEditorState] = useState(() => EditorState.createEmpty());

  // const handleKeyCommand = (command, editorState) => {
  //   const newState = RichUtils.handleKeyCommand(editorState, command);
  //   if (newState) {
  //     setEditorState(newState);
  //     return 'handled';
  //   }
  //   return 'not-handled';
  // };

  // const onChange = (newState) => {
  //   setEditorState(newState);
  // };
   

  return (
    
    <div className="container mx-auto mt-8">
      <form onSubmit={(e)=>onSubmit(e)}>
      <div className="grid grid-cols-3 gap-4">
        {/* first line */}
        <div className="relative ml-4">
          <label htmlFor="title" className="block">Title * </label>
          <input type="text" id="title" name="Title" value={Title} className="w-full px-4 py-2 mt-1 rounded-md border border-gray-300 focus:border-blue-500 focus:outline-none focus:ring-blue-500" 
          onChange={(e)=>{
            onInputChange(e)
          }}
          />
        </div>

        <div className="relative">
          <label htmlFor="author" className="block">Author:</label>
          <select id="author" name="Authors" value={Authors} className="w-full px-4 py-2 mt-1 rounded-md border border-gray-300 focus:border-blue-500 focus:outline-none focus:ring-blue-500"
          onChange={(e)=>{
            onInputChange(e)
          }}>
            <option value="" disabled>Search</option>
            <option value="author1">Author 1</option>
            <option value="author2">Author 2</option>
            <option value="author3">Author 3</option>
          </select>
        </div>

        <div className="relative mr-4">
          <label htmlFor="url" className="block">Public URL:</label>
          <input type="text" id="url" name="PublicUrl" value={PublicUrl} className="w-full px-4 py-2 mt-1 rounded-md border border-gray-300 focus:border-blue-500 focus:outline-none focus:ring-blue-500"
          onChange={(e)=>{
            onInputChange(e)
          }} />
        </div>


        {/* second line */}
         <div className="relative ml-4">
          <label htmlFor="articleDate" className="block">Article Date *</label>
          <input type="date" id="articleDate" name="ArticleDate" value={ArticleDate} className="w-full px-4 py-2 mt-1 rounded-md border border-gray-300 focus:border-blue-500 focus:outline-none focus:ring-blue-500"
          onChange={(e)=>{
            onInputChange(e)
          }} />
        </div>

        <div className="relative">
          <label htmlFor="accessCategory" className="block">Access Category:</label>
          <select id="accessCategory" name="AccessCategory" value={AccessCategory} className="w-full px-4 py-2 mt-1 rounded-md border border-gray-300 focus:border-blue-500 focus:outline-none focus:ring-blue-500"
          onChange={(e)=>{
            onInputChange(e)
          }}>
            <option value="" disabled>FREE</option>
            <option value="category1">Category 1</option>
            <option value="category2">Category 2</option>
            <option value="category3">Category 3</option>
          </select>
        </div>

        <div className="relative mr-4">
          <label htmlFor="expiryDate" className="block">Free View Expiry</label>
          <input type="date" id="expiryDate" name="FreeViewExpiry" value={FreeViewExpiry} className="w-full px-4 py-2 mt-1 rounded-md border border-gray-300 focus:border-blue-500 focus:outline-none focus:ring-blue-500"
          onChange={(e)=>{
            onInputChange(e)
          }} />
        </div>

        {/* third line */}

        {/* <div className="relative ml-4">
          <label htmlFor="description" className="block">Description:</label>
          <textarea id="description" name="description" className="w-full px-4 py-2 mt-1 rounded-md border border-gray-300 focus:border-blue-500 focus:outline-none focus:ring-blue-500"></textarea>
        </div> */}
    <input type="hidden" name="Description" value={Description} />
    <div className="relative ml-4">
      <label htmlFor="description" className="block">Description <InfoIcon className="w-3 h-3"/> </label>
      <ReactQuill
        theme="snow"
        value={Description}
        onChange={(e)=>{
            onInputChange(e)
        }}
      />
    </div>
      

        <div className="relative">
          <label htmlFor="featuredImage" className="block">Featured Image:850w*700h <InfoIcon className="w-3 h-3"/> *</label>
          <div className="w-full h-32 border border-dashed border-gray-300 flex items-center justify-center cursor-pointer">
            
          <div>
            <Input
            id="file-input"
            type="file"
            name="Featureimage"
            value={Featureimage}
            inputProps={{ accept: 'image/*' }}
            style={{ display: 'none' }}
            onChange={(e)=>{
            onInputChange(e)
            }}
          />

          <label htmlFor="file-input">
            <InputAdornment position="end">
              <IconButton component="span">
                <CloudUploadIcon/>
              </IconButton>
          </InputAdornment>
          </label>
          
          {/* {selectedFile && <p>Selected File: {selectedFile.name}</p>} */}
            {selectedFile ? (
              <img src={URL.createObjectURL(selectedFile)} alt="PDF/Image" className="h-full w-full object-cover" />
            ) : (
              <p>Drag & Drop or Click to Upload</p>
            )}

          </div>
      </div>
    </div>

        <div className="relative mr-4">
          <label htmlFor="pdfImage" className="block">PDF/Image <InfoIcon className="w-3 h-3"/></label>
          <div className="w-full h-32 border border-dashed border-gray-300 flex items-center justify-center cursor-pointer">

            <div>
            <Input
            id="file-input1"
            type="file"
            name="Pdfimg"
            value={Pdfimg}
            inputProps={{ accept: 'image/*' }}
            style={{ display: 'none' }}
            onChange={(e)=>{
            onInputChange(e)
            }}
          />

          <label htmlFor="file-input1">
            <InputAdornment position="end">
              <IconButton component="span">
                <CloudUploadIcon/>
              </IconButton>
          </InputAdornment>
          </label>
          
          {/* {selectedFile && <p>Selected File: {selectedFile.name}</p>} */}
            { PDFFile ? (
              <img src={URL.createObjectURL(PDFFile)} alt="PDF/Image" className="h-full w-full object-cover" />
            ) : (
              <p>Drag & Drop or Click to Upload</p>
            )}

          </div>

          </div>

          <div className="flex items-center mt-2 grid grid-cols-3 gap-4">
            <div className="flex items-center mr-6">
              <input type="checkbox" id="pdfCheckbox" name="pdfCheckbox" className="mr-2" />
              <label htmlFor="pdfCheckbox" className="mr-2">PDF</label>
            </div>
            <div className="flex items-center mr-6">
              <input type="checkbox" id="imageCheckbox" name="imageCheckbox" className="mr-2" />
              <label htmlFor="imageCheckbox" className="mr-2">Image</label>
            </div>
            <div className="flex items-center">
              <input type="checkbox" id="urlCheckbox" name="urlCheckbox" />
              <label htmlFor="urlCheckbox">Link of URL</label>
            </div>
          </div>
          </div>
      </div>


      <div className='text-size-20 font-bold ml-4'>
      <p >For in-text advertisement,add this "dispaly-middle-ads-here" text in the 
        description above:
      </p>
      </div>

      <br/>

      <div className="flex items-center ml-4">
          <div className='mr-2'>
           
          { <Button type="submit" color='success' variant="contained" startIcon={<SaveIcon />}
          >
            Save
          </Button> }
          

          </div>
          <div className='mr-4'>
          <Button onClick={()=>{
            setgotolist(true);
          }}variant="contained" startIcon={<MenuIcon />}>
            List
          </Button>
          </div>
      </div>
      </form>
      <br/>

      <div className='font-bold ml-4'>
      <p>(*) All fields are mandatory.</p>
      </div>
    </div>
  )
}

export default Form;
