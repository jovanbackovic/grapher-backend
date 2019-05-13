import React from 'react';
import DiceRollingForm from './dice_rolling/DiceRollingForm'
import DiceRollingGraph from './dice_rolling/DiceRollingGraph'

import dice_rolling from '../apis/dice_rolling';


class App extends React.Component {

  state = {
    loading: false
  };

  onDiceRollSubmit = async (dices, rolls) => {
    this.setState({loading : true});
    const response = await dice_rolling.get('/', { 
      params : {
        dices, rolls
      }
    });
    this.setState(
      {
        diceRollingResult : response.data,
        loading: false
      }
    );
  }

  render(){
    return( 
      <div className="ui container">
          <DiceRollingForm onDiceRollSubmit={this.onDiceRollSubmit} loading={this.state.loading}/>
          <div className="ui grid">
              <div className="ui row">
                  <div className="one wide column" />
                  <div className="fourteen wide column">
                      <DiceRollingGraph diceRollingResult={this.state.diceRollingResult} loading={this.state.loading}/>
                  </div>
                  <div className="one wide column" />
              </div>
            </div>
      </div>
  );
  }  
    
};


export default App; 

