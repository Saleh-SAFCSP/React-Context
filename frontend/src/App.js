import React, { useEffect, useState, useContext } from 'react';
import {
  Button,
  ChakraProvider,
  Flex,
  HStack,
  Image,
  Input,
  Link,
  Text,
  VStack,
} from '@chakra-ui/react';
import Logo from './img/logobs.png';
import theme from './theme/theme';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Login from './pages/Login';
import Register from './pages/Register';
import Dashboard from './pages/Dashboard';
import RequireAuth from './components/RequireAuth';
import AuthContext from './context/AuthContext';

const App = () => {
  return (
    <ChakraProvider theme={theme}>
      <BrowserRouter>
        <Routes>
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route element={<RequireAuth />}>
            <Route path="/dashboard" element={<Dashboard />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </ChakraProvider>
  );
};

export default App;
