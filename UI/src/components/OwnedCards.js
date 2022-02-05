import React from 'react';
import Card from './Card';
import { getCards } from '../api/cardService';
import "./OwnedCards.css";

export default function OwnedCards(props){

    const [listItems,setListItems] = React.useState([])
    

    // console.log(props)

    React.useEffect(()=>{
        console.log(props)
        getCards(props.props.userName).then((response)=>{
            setListItems(response.data);
        }).catch((e)=>{
            localStorage.clear();
        })
    },[])

    return (
        <div>
        <div className="title-wrapper">Your cards:</div>
        <br></br>
    <div className="CardsWrapper">
        {listItems.map(function (card, idCard){
            return (<li className="CardLi" key={idCard}>{<Card params={card}/>}</li>)
        })}
    </div>
    </div>)
}