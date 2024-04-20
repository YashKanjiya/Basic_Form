import React from 'react'

import AddUpdate from './pages/AddUpdate';
import List from './pages/List';
import View from './pages/View';

import { Routes, Route } from "react-router-dom";


export const App = () => {
  return (
    <>
      <React.StrictMode>
          <Routes>
            {/* Route  */}
            <Route path="/" element={<List/>} />
            <Route path="/List" element={<List/>} />
            <Route path="/addupdate" element={<AddUpdate/>} />

            {/* Nested Router */}
            <Route path='List'>
              <Route path="view" element={<View/>} />
            </Route>

          </Routes>
      </React.StrictMode>
    </>
  )
}

export default App;
