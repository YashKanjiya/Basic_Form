import React from 'react';

import AddCircleOutlineIcon from '@mui/icons-material/AddCircleOutline';
import Button from '@mui/material/Button';

export const Header = () => {
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
          <Button className='bg-vlue-400' variant="contained" startIcon={<AddCircleOutlineIcon />}>
            Add Article
          </Button>
          </div>
        </div>

      </div>
    </>
  )
}

export default Header;