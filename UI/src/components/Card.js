import React from 'react';
import '../components/InputCardForm.css';
import bronzeImage from '../assets/BRONZE.png';
import silverImage from '../assets/SILVER.png';
import goldImage from '../assets/GOLD.png';
import diamondsImage from '../assets/DIAMONDS.png';
import clubsImage from '../assets/CLUBS.png';
import heartsImage from '../assets/HEARTS.png';
import spadesImage from '../assets/SPADES.png';

export default class Card extends React.Component{
    constructor(props) {
        super(props);
        this.state= {
            params : props.params
        }
      }

    getImageType(cardType){
        switch (cardType){
            case 'BRONZE':
                return bronzeImage;
                break;
            case 'SILVER':
                return silverImage;
                break;
            case 'GOLD':
                return goldImage;
                break;
            default:
                console.log('Sorry');
        }
    }

    getImageSuit(cardSuit){
        switch (cardSuit){
            case 'DIAMONDS':
                return diamondsImage;
                break;
            case 'CLUBS':
                return clubsImage;
                break;
            case 'HEARTS':
                return heartsImage;
                break;
            case 'SPADES':
                return spadesImage;
                break;
            default:
                console.log('Sorry');
        }
    }

    componentDidUpdate(prevProps) {
        if(prevProps.params !== this.props.params) {
            this.setState({params: this.props.params});
        }
    }

    render(){
        // console.log("../assets/" + this.state.params.cardType +".PNG");
        return (
        <div className={"Preview"}>
            <div className="CardName">{this.state.params.name}</div>
            <img className="CardTypeImage" src={this.getImageType(this.state.params.cardType)}></img>
            <img className="CardSuitImage" src={this.getImageSuit(this.state.params.cardSuit)}></img>
            <div className="CardNumber">{this.state.params.number}</div>
        </div>
        );
    }
}