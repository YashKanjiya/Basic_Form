import React,{useState,useMemo,useCallback} from 'react'
import CloudUploadIcon from '@mui/icons-material/CloudUpload';
import InfoIcon from '@mui/icons-material/Info';

import axios from 'axios';

// import { Editor, EditorState, RichUtils } from 'draft-js';
// import 'draft-js/dist/Draft.css';
import { useNavigate } from 'react-router-dom';

import SaveIcon from '@mui/icons-material/Save';
import MenuIcon from '@mui/icons-material/Menu';
import Button from '@mui/material/Button';

import ReactQuill from 'react-quill';
import 'react-quill/dist/quill.snow.css';


export const Form = () => {

  //Navigate List
  const navigate = useNavigate();
  const[gotolist,setgotolist]=useState(false);

  if(gotolist){
    return navigate("/");
  }

  //image 
  const [featuredImage, setFeaturedImage] = useState(null);
  const [pdfImage, setPdfImage] = useState(null);

  const handleFileChange = (event, setter) => {
    const file = event.target.files[0];
    setter(file);
  };

  const handleDragOver = (event) => {
    event.preventDefault();
  };

  const handleDrop = (event, setter) => {
    event.preventDefault();
    const file = event.dataTransfer.files[0];
    setter(file);
  };

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
   const [value, setValue] = useState('');

  const handleChange = (content) => {
    setValue(content);
  };


  const onSubmit = async (e) =>{
    e.preventDefault();
    await axios.post()
  }

  // mhc0931_882024 jan 15 
  // 021420107896
  // IFcod icici0006427
  // hc_839
  // id dsd_33_109
  // adare mumbai@gmail.com

  return (
  <form onSubmit={(e)=>onSubmit(e)}>
    <div className="container mx-auto mt-8">
      <div className="grid grid-cols-3 gap-4">
        {/* first line */}
        <div className="relative ml-4">
          <label htmlFor="title" className="block">Title * </label>
          <input type="text" id="title" name="title" className="w-full px-4 py-2 mt-1 rounded-md border border-gray-300 focus:border-blue-500 focus:outline-none focus:ring-blue-500" />
        </div>

        <div className="relative">
          <label htmlFor="author" className="block">Author:</label>
          <select id="author" name="author" className="w-full px-4 py-2 mt-1 rounded-md border border-gray-300 focus:border-blue-500 focus:outline-none focus:ring-blue-500">
            <option value="" disabled>Search</option>
            <option value="author1">Author 1</option>
            <option value="author2">Author 2</option>
            <option value="author3">Author 3</option>
          </select>
        </div>

        <div className="relative mr-4">
          <label htmlFor="url" className="block">Public URL:</label>
          <input type="text" id="url" name="url" className="w-full px-4 py-2 mt-1 rounded-md border border-gray-300 focus:border-blue-500 focus:outline-none focus:ring-blue-500" />
        </div>


        {/* second line */}
         <div className="relative ml-4">
          <label htmlFor="articleDate" className="block">Article Date *</label>
          <input type="date" id="articleDate" name="articleDate" className="w-full px-4 py-2 mt-1 rounded-md border border-gray-300 focus:border-blue-500 focus:outline-none focus:ring-blue-500" />
        </div>

        <div className="relative">
          <label htmlFor="accessCategory" className="block">Access Category:</label>
          <select id="accessCategory" name="accessCategory" className="w-full px-4 py-2 mt-1 rounded-md border border-gray-300 focus:border-blue-500 focus:outline-none focus:ring-blue-500">
            <option value="" disabled>FREE</option>
            <option value="category1">Category 1</option>
            <option value="category2">Category 2</option>
            <option value="category3">Category 3</option>
          </select>
        </div>

        <div className="relative mr-4">
          <label htmlFor="expiryDate" className="block">Free View Expiry</label>
          <input type="date" id="expiryDate" name="expiryDate" className="w-full px-4 py-2 mt-1 rounded-md border border-gray-300 focus:border-blue-500 focus:outline-none focus:ring-blue-500" />
        </div>

        {/* third line */}

        {/* <div className="relative ml-4">
          <label htmlFor="description" className="block">Description:</label>
          <textarea id="description" name="description" className="w-full px-4 py-2 mt-1 rounded-md border border-gray-300 focus:border-blue-500 focus:outline-none focus:ring-blue-500"></textarea>
        </div> */}

    <div className="relative ml-4">
      <label htmlFor="description" className="block">Description <InfoIcon className="w-3 h-3"/> </label>
      <ReactQuill
        theme="snow"
        value={value}
        onChange={handleChange} 
      />
    </div>
      

        <div className="relative">
          <label htmlFor="featuredImage" className="block">Featured Image:850w*700h <InfoIcon className="w-3 h-3"/> *</label>
          <div
            className="w-full h-32 border border-dashed border-gray-300 flex items-center justify-center cursor-pointer"
            onDragOver={handleDragOver}
            onDrop={(event) => handleDrop(event, setFeaturedImage)}
          >
            <div className='bg-white'>
              <CloudUploadIcon/>
            </div>
            <br/>
            {featuredImage ? (
              <img src={URL.createObjectURL(featuredImage)} alt="Featured" className="h-full w-full object-cover" />
            ) : (
              <p>Drag & Drop or Click to Upload</p>
            )}

        </div>
          <input
            type="file"
            id="featuredImage"
            name="featuredImage"
            className="hidden"
            onChange={(event) => handleFileChange(event, setFeaturedImage)}
            accept="image/*"
          />
        </div>

        <div className="relative mr-4">
          <label htmlFor="pdfImage" className="block">PDF/Image <InfoIcon className="w-3 h-3"/></label>
          <div
            className="w-full h-32 border border-dashed border-gray-300 flex items-center justify-center cursor-pointer"
            onDragOver={handleDragOver}
            onDrop={(event) => handleDrop(event, setPdfImage)}
          >

            <div className='bg-white'>
              <CloudUploadIcon/>
            </div>
            <br/>
            {pdfImage ? (
              <img src={URL.createObjectURL(pdfImage)} alt="PDF/Image" className="h-full w-full object-cover" />
            ) : (
              <p>Drag & Drop or Click to Upload</p>
            )}
          </div>
          <input
            type="file"
            id="pdfImage"
            name="pdfImage"
            className="hidden"
            onChange={(event) => handleFileChange(event, setPdfImage)}
            accept=".pdf, image/*"
          />

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
          <Button color='success' variant="contained" startIcon={<SaveIcon />}>
            Save
          </Button>
          </div>
          <div className='mr-4'>
          <Button onClick={()=>{
            setgotolist(true);
          }}variant="contained" startIcon={<MenuIcon />}>
            List
          </Button>
          </div>
      </div>

      <br/>

      <div className='font-bold ml-4'>
      <p>(*) All fields are mandatory.</p>
      </div>
    </div>
  </form>
  )
}

export default Form;
