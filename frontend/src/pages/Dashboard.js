import { Button, VStack } from '@chakra-ui/react';
import React, { useContext, useEffect } from 'react';
import { Navigate, useNavigate } from 'react-router-dom';
import AuthContext from '../context/AuthContext';

const Dashboard = () => {
  const navigate = useNavigate();
  // useEffect(() => {
  //   const requestUsers = async () => {
  //     const request = await fetch('/api/v1/auth/users');
  //     const data = await request.json();
  //     console.log(data);
  //   };
  //   requestUsers();
  // }, []);

  const { logout, removeIsLogged } = useContext(AuthContext);

  return (
    <VStack>
      <Button
        onClick={() => {
          const isLogedOut = logout();
          if (isLogedOut) {
            removeIsLogged();
            navigate('/login');
          }
        }}
      >
        Logout !
      </Button>
    </VStack>
  );
};

export default Dashboard;
