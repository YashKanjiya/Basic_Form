import React from 'react'

import Action from '../components/View/Action';
import Artical from '../components/View/Artical';
import Bottom from '../components/View/Bottom';

export const View = () => {
  return (
    <>
      <div>
        <Action/>
        <Artical/>
      </div>      
      <div>
        <Bottom/>
      </div>
    </>
  )
}

export default View;