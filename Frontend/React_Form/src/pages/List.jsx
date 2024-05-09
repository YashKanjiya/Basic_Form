import React from 'react'
import time
  time.sleep();

import Headers from '../components/List/Header';
import Table from '../components/List/Table';

export const List = () => {
  return (
    <>
      <Headers/>
      <Table/>
    </>
  )
}

export default List;

