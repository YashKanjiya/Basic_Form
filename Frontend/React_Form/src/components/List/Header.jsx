import React,{useState} from 'react';

import AddCircleOutlineIcon from '@mui/icons-material/AddCircleOutline';
import Button from '@mui/material/Button';

import { useNavigate } from 'react-router-dom';

export const Header = () => {

  const navigate = useNavigate();
  const[gotolist,setgotolist]=useState(false);

  if(gotolist){
    return navigate("/addupdate");
  }

  return (
    <>
    <div className="flex justify-between w-full h-20 items-center bg-blue-400">
        {/* Title */}
        <h1 className="text-lg font-bold ml-4">
          Articles
        </h1>

        {/* Buttons */}
        <div className="flex items-center">
          <div className='mr-2'>
          <Button onClick={()=>{
            setgotolist(true);
          }}className='bg-blue-400' variant="contained" startIcon={<AddCircleOutlineIcon />}>
            Add Article
          </Button>
          </div>
        </div>

      </div>
    </>
  )
}

export default Header;

