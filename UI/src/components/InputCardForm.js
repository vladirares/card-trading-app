import React  from 'react';
import { Button } from 'react-bootstrap';
import {addCard} from '../api/cardService';
import Card from './Card';
import './InputCardForm.css';

export default class InputCardForm extends React.Component {
  constructor(props) {
    super(props);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleChange = this.handleChange.bind(this);
    this.state={}
  }

  handleSubmit(event) {
    event.preventDefault();
    const x = {
      'username' : event.target.username.value,
      'name' : event.target.name.value,
      'cardSuit' : event.target.cardSuit.value,
      'number' : event.target.number.value,
      'cardType' : event.target.cardType.value
    }
    this.setState(x)
    console.log(x)
    addCard(x.username, x)
  }

  handleChange(event) {
    event.preventDefault();

    this.setState(prevState => {
      prevState[event.target.name] = event.target.value
      prevState[event.target.cardType] = event.target.value
      prevState[event.target.cardSuit] = event.target.value
      prevState[event.target.number] = event.target.value
      return {
        ...prevState,
      }
    })
  }


  render() {
    return (
        <div className="Wrapper">
            <form className = "InputCard" onSubmit={this.handleSubmit}>
                <label>
                    Username:
                </label>
                    <br></br>
                    <input type="text" name="username" onChange={this.handleChange} />
                
                <br></br>
                <br></br>
                <br></br>
                <label>
                    Card:
                </label>
                    <br></br>
                    <label>name</label>
                      <br></br>
                    <input type="text"  name="name" onChange={this.handleChange} />
                      <br></br>
                    <label>suit</label>
                      <br></br>
                    {/* <input type="text"  name="cardSuit" onChange={this.handleChange} /> */}
                    <select name="cardSuit" onChange={this.handleChange} >
                      <option value="DIAMONDS">DIAMONDS</option>
                      <option value="SPADES">Spades</option>
                      <option value="HEARTS">Hearts</option>
                      <option value="CLUBS">Clubs</option>
                    </select>
                      <br></br>
                    <label>number</label>
                      <br></br>
                    <input type="number"  name="number" onChange={this.handleChange} />
                      <br></br>
                    <label>type</label>
                      <br></br>
                    {/* <input type="text"  name="cardType" onChange={this.handleChange} /> */}
                    <select defaultValue="BRONZE" name="cardType" onChange={this.handleChange} >
                      <option value="BRONZE">Bronze</option>
                      <option value="SILVER">Silver</option>
                      <option value="GOLD">Gold</option>
                    </select>
                <br></br><br></br>
                <Button size="lg" type="submit" value="Submit" >Add Card</Button>
            </form> 
            <Card cardClass={"Preview"} params={this.state} className="InputCard"/>
        </div>
    );
  }
}



