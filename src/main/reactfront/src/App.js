import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Profile from './conponent/Profile';

const App = () => {
  // state 정의 : 변경될 데이터를 state 에 정의하여 서버통신 후 Front 에 출력하게됨
  const [profiles, setProfiles] = useState([]);
 
  useEffect(() => {
      // 1. axios 객체 전달 이용
      // axios({
      //   method : 'GET',
      //   url : '/user/all'
      // }).then(response => { setProfiles(response.data)})
      
      // 2. get().then() 이용
      axios.get('/user/all')
           .then((response) => {
            setProfiles(response.data)
          });

      // 3. try catch 이용
      // try{
      //   const response = await axios.get('/user/all');
      //   setProfiles(response.data);
      // }catch(error) {
      //     console.log(error)
      // }
  }, []); // Hook function

  return (
    <div>
      <h1>Data를 가져와서 ul 로 출력한다 컴포넌트를 이용</h1>
      {profiles.map((data)=> {
        <Profile id={data.id} name={data.name} phone={data.phone} address={data.address} />
      })}
    </div>
  )
};

export default App;