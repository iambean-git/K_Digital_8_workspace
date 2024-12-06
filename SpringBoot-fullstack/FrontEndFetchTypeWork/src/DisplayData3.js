import React, { useState, useEffect } from 'react';
import axios from 'axios';

const DataDisplay3 = () => {
  const [dataMember, setDataMember] = useState([]);
  const [dataBoard, setDataBoard] = useState([]);
  // 화면에 출력할 데이터 타입 설정 (member/board)
  const [showItem, setShowItem] = useState([]);

  useEffect(() => {
    if (showItem === 'member') {
      loadMember();
    } else if (showItem === 'board') {
      loadBoard();
    }
  }, [showItem]); // showItem이 변경될 때만 실행  

  const loadMember = async () => {
    await axios.get('http://localhost:8080/member', {
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MDE1Nzk5NDcsInVzZXJuYW1lIjoidXNlciJ9.uXtfhi8iAFyKVX_kTZeIr-LLwtku_bLoqGPBqo7vQoY'
      }
    })
    .then(resp => {
      setDataMember(resp.data.jsondata);
      setShowItem('member');
    }).catch(error => {
      console.error('Error fetching Member:', error);
    });
  };

  const loadBoard = async () => {
    await axios.get('http://localhost:8080/board', {
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MDE1Nzk5NDcsInVzZXJuYW1lIjoidXNlciJ9.uXtfhi8iAFyKVX_kTZeIr-LLwtku_bLoqGPBqo7vQoY'
      }
    })
    .then(resp => {
      setDataBoard(resp.data.jsondata);
      setShowItem('board');
    }).catch(error => {
      console.error('Error fetching Board:', error);
    });
  };

  const loadData = () => {
    let tableContent;
    if (showItem === 'member') {
      tableContent = (
        <table align="center">
          <thead>
            <tr><th>Username</th><th>Password</th><th>Alias</th><th>Role</th><th>Enabled</th></tr>
          </thead>
          <tbody>
            {dataMember.map(member => (
              <tr key={member.username}>
                <td>{member.username}</td>
                <td>[encrypted]</td>
                <td>{member.alias}</td>
                <td>{member.role}</td>
                <td>{member.enabled?'active':'inactive'}</td>
              </tr>
            ))}
          </tbody>
        </table>
      );   
    } else if (showItem === 'board') {
      tableContent = (
        <table align="center">
          <thead>
            <tr>
              <th>ID</th><th>title</th><th>writer</th><th>content</th><th>createDate</th>
            </tr>
          </thead>
          <tbody>
            {dataBoard.map(board => (
              <tr key={board.id}>
                <td>{board.id}</td>
                <td>{board.title}</td>
                <td>{board.writer}</td>
                <td>{board.content}</td>
                <td>{board.createDate}</td>
              </tr>
            ))}
          </tbody>
        </table>
      );
    } else {
      console.log("Not Selected");
      tableContent = (
        <table align="center">
          <tr><td>선택하세요.</td></tr>
        </table>)
    }
    return tableContent;
  };
  return (
    <div>
      <h2>Data Display3</h2>
      <button onClick={() => setShowItem('member')}>Member</button>
      <button onClick={() => setShowItem('board')}>Board</button>       
      <div>{loadData()}</div>
    </div>
  );
};

export default DataDisplay3;