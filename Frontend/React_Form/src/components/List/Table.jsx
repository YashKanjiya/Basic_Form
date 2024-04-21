import React,{useState,useEffect} from 'react'
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

import Button from '@mui/material/Button';
import VisibilityIcon from '@mui/icons-material/Visibility';
import VisibilityOffIcon from '@mui/icons-material/VisibilityOff';
import DriveFileRenameOutlineIcon from '@mui/icons-material/DriveFileRenameOutline';
import DeleteIcon from '@mui/icons-material/Delete';

export const Table = () => {

  const [data, setData] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get("http://localhost:9898/user/txn_master");
        console.log(response.data.data.Article);
        setData(response.data.data.Article);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };
    fetchData();
  }, []);

const handleDelete = async (id) => {
  try {
    await axios.delete(`http://localhost:9898/user/txn_master/${id}`);
    navigate("/");
    //console.log(`Item with ID ${id} deleted successfully`);
  } catch (error) {
    console.error('Error deleting item:', error);
  }
};

  return (
    <>
    <div className="flex justify-between items-center">
      <div>Show 10 entries</div>
      <div className="flex items-center">
        <button className="bg-white-500  hover:bg-blue-700 text-black font-bold py-2 px-4 rounded">Search</button>
        <input
          type="text"
          className="border rounded px-2 py-1 mr-2"
        />
      </div>
    </div>

    <br/>
     <table className="table-auto w-full border border-collapse border-gray-400">
          <thead>
            <tr>
              <th className="px-4 py-2 border border-gray-400">Title</th>
              <th className="px-4 py-2 border border-gray-400">Date</th>
              <th className="px-4 py-2 border border-gray-400">Author</th>
              <th className="px-4 py-2 border border-gray-400">Preference</th>
              <th className="px-4 py-2 border border-gray-400">Status</th>
              <th className="px-4 py-2 border border-gray-400">Published On</th>
              <th className="px-4 py-2 border border-gray-400">Actions</th>
            </tr>
          </thead>

          <tbody>
            {data.map((item, index) => (
              <tr key={index}>
                <td className="border border-gray-400 px-4 py-2">{item.Title}</td>
                <td className="border border-gray-400 px-4 py-2">{item.ArticleDate}</td>
                <td className="border border-gray-400 px-4 py-2">{item.Authors}</td>
                <td className="border border-gray-400 px-4 py-2">{item.Description}</td>
                <td className="border border-gray-400 px-4 py-2">{item.status ? 
                <Button color="success" variant="contained">
                Active
                </Button>:<Button color="success" variant="contained">Not Active</Button>
                }
                </td>

                <td className="border border-gray-400 px-4 py-2">{item.publishedonconnect ? 
                <Button color="success" variant="contained">
                Published
                </Button> : 
                <Button color="success" variant="contained">
                Not Published
                </Button>}
                </td>

                <td className="border border-gray-400 px-4 py-2">
                  {/* Add action buttons here */}
                  <div> <VisibilityIcon/>  <DriveFileRenameOutlineIcon/> </div>
                  <div> <VisibilityIcon className='text-blue-500'/> <DeleteIcon onClick={() => handleDelete(item._id)}/> </div>

                </td>
              </tr>
            ))}
          </tbody>
          
        
      </table>
    </>
  )
}

export default Table;