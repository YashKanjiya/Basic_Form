import React from 'react'

import SaveIcon from '@mui/icons-material/Save';
import MenuIcon from '@mui/icons-material/Menu';
import Button from '@mui/material/Button';

export const Buttonicon = () => {
  return (
    <>
        <Button type="submit" color='success' variant="contained" startIcon={<SaveIcon />}>
            Save
        </Button>
    </>
  )
}

export default Buttonicon;
