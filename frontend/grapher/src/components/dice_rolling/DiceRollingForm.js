import React from 'react';

class DiceRollingForm extends React.Component {

    state = { dices : "2", rolls : "100" };

    onFormSubmit = (event) => {
        event.preventDefault();
        if(!this.props.loading){
            this.props.onDiceRollSubmit(this.state.dices, this.state.rolls);
        } else{
            console.log("Backoooo!!!");
        }
    }

    onInputChange = (event) => {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        
        this.setState({[name]: value});

    }

    render(){
        const { loading } = this.props;
        return (
            <div className="ui segment">
                <form className="ui form" onSubmit={this.onFormSubmit}>
                    <div className="field">
                        <label>Number of dices</label>
                        <input type="number" value={this.state.dices} 
                            name="dices" onChange={this.onInputChange} disabled={loading}/>
                    </div>
                    <div className="field">
                        <label>Number of rolls</label>
                        <input type="number" value={this.state.rolls} 
                            name="rolls" onChange={this.onInputChange} disabled={loading}/>
                    </div>
                    <input type="submit" className="ui secondary button" value="Roll" disabled={loading}/>
                </form>
            </div>
        );
    }
    
}

export default DiceRollingForm;