import React,{useState} from 'react'

import SaveIcon from '@mui/icons-material/Save';
import MenuIcon from '@mui/icons-material/Menu';
import Button from '@mui/material/Button';

import { useNavigate } from 'react-router-dom';

export const Header = () => {

  const navigate = useNavigate();

  const[gotolist,setgotolist]=useState(false);

  if(gotolist){
    return navigate("/");
  }

  return (
    <>
      <div className="flex justify-between w-full h-20 items-center">
        {/* Title */}
        <h1 className="text-lg font-bold ml-4">
          Add Article (CeFro Connect Section)
        </h1>

        {/* Buttons */}
        <div className="flex items-center">
          <div className='mr-2'>
          <Button color='success' variant="contained" startIcon={<SaveIcon />}>
            Save
          </Button>
          </div>
          <div className='mr-4'>
          <Button onClick={()=>{
            setgotolist(true);
          }} variant="contained" startIcon={<MenuIcon />}>
            List
          </Button>
          </div>
        </div>
      </div>

      <div className="mr-7">
        <hr className="border-b border-gray-800 w-full ml-3" />
      </div>
    </>
  );
}

export default Header;
