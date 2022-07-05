import React, { useEffect, useState } from 'react';
import axios from 'axios';

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
  }, []);

  return (
    <ul>
      {profiles.map(profile => (
        <li key={profile.id}>  
          <div>{profile.name}</div>
          <div>{profile.phone}</div>
          <div>{profile.address}</div>W
        </li>
        ))}
    </ul>
  )

};

export default App;