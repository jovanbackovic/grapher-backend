import React from 'react';
import {
    BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, Legend,ResponsiveContainer
  } from 'recharts';

class DiceRollingGraph extends React.PureComponent {
    
    render() {
        var dataPoints = [];
        const {diceRollingResult} = this.props;
        if(diceRollingResult){
            const { graphData } = diceRollingResult;
            dataPoints =  Object.entries(graphData).map((key, value) => {
                return {x: key[0], y: key[1]}
            });
            const loader = <div className="ui active inverted dimmer"> <div className="ui loader"></div> </div>
            return (
                <div className="ui segment">
                    <ResponsiveContainer width="80%" height="80%" aspect={1.6} >
                        <BarChart
                            data={dataPoints}
                            margin={{
                            top: 5, right: 5, left: 5, bottom: 5,
                            }}
                        >
                            <CartesianGrid strokeDasharray="3 3" />
                            <XAxis dataKey="x" />
                            <YAxis />
                            <Tooltip />
                            <Legend />
                            <Bar dataKey="y" name="Sum result" fill="#8884d8" />
                        </BarChart>
                    </ResponsiveContainer>
                    {this.props.loading ? loader : ""}
                </div>
            );
        }
        return(
            <div></div>
        );
        
	}

}

export default DiceRollingGraph;

