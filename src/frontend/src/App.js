import React, {Component} from 'react';
import './App.css';

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            isBidSet: false,
            currentBid: 0.0,
            inputBid: 0.0

        };

    }

    handleChange(event) {
        this.setState({inputBid: event.target.value});
    }

    handleButtonPress(event) {
        console.log(this.state.inputBid);
    }

    render() {

        let currentBidLabel = '';

        if (this.state.isBidSet) {
            currentBidLabel = (
                <label>Текущая ставка: {this.state.currentBid}</label>
            )
        }

        return (
            <div>
                {currentBidLabel}
                <input type="text"  value={this.state.inputBid} onChange={this.handleChange.bind(this)} placeholder="Ваша ставка"  />
                <button onClick={this.handleButtonPress.bind(this)}>Отправить</button>
            </div>
        );
    }
}

export default App;
