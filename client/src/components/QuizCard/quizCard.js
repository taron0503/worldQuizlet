import { Component } from "react"
import "./style.css"

export default class QuizCard extends Component{
    constructor(props){
        super(props)
    }
    render(){
        let quiz = this.props.quiz;
        return <div className="quizCard">
            <header className="questionHeader">
                {this.props.quiz.question}
            </header>
            
            <div className = "answers">
            {quiz.options.map(option=>{
                if(this.props.quizStatus==="finished"){
                    if(option == this.props.quiz.answer && this.props.isCorrect){
                        return <div key = {option} className = "answerItem correct">{option}</div>  
                    }
                    if(option == this.props.quiz.answer && !this.props.isCorrect){
                        return <div key = {option} className = "answerItem notcorrect">{option}</div>  
                    }

                    return <div key = {option} className = "answerItem">{option}</div>  

                }

                if(option == this.props.quiz.answer){
                    return <div key = {option} className = "answerItem is-selected" onClick={()=>this.props.onSelect(option)}>{option}</div>  
                }
                return <div key = {option} className = "answerItem" onClick={()=>{
                    return this.props.onSelect(option)}}>{option}</div> 
            }
            )}

            </div>
        </div>
    }
}