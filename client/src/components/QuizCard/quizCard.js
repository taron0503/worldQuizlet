import { Component } from "react"
import "./style.css"

export default class QuizCard extends Component{
    constructor(props){
        super(props)
    }
    render(){
        let quiz = this.props.quiz;
        console.log("quizqard")
        return <div className="QuizCard">
            <header className="questionHeader">
                {this.props.quiz.question}
            </header>
            
            <div className = "answers">
            {quiz.options.map(option=>{
                if(option == this.props.quiz.answer){
                    return <div key = {option} className = "answerItem is-selected" onClick={()=>this.props.onSelect(option)}>{option}</div>  
                }
                return <div key = {option} className = "answerItem" onClick={()=>{
                    // console.log("option")
                    // console.log(option)
                    return this.props.onSelect(option)}}>{option}</div> 
            }
            )}

            </div>
        </div>
    }
}