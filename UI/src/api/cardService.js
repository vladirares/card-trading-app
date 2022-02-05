import React from 'react';
import axios from 'axios';

const getToken=()=>{
    return localStorage.getItem('USER_KEY');
}

export const addCard=(username, cardDto)=>{
    return axios({
        method:'POST',
        url:`${process.env.hostUrl||'http://localhost:8080'}/api/v1/card/add/` + username,
        headers:{
            'Authorization':'Bearer '+getToken()
        },
        data:cardDto
    }).then(()=>{window.location.reload()} )
}

export function getCards(userName) {
    console.log(userName);
    return axios({
        method: 'GET',
        url: `${process.env.hostUrl || 'http://localhost:8080'}/api/v1/card/state/` + userName,
        headers: {
            'Authorization': 'Bearer ' + getToken()
        }
    });
}

