import { Component } from "react"
import "./style.css"

export default class QuizCard extends Component{
    render(){
        return <div className="QuizCard">
            <header className="questionHeader">
                What is a correct syntax to output "Hello World" in Java?
            </header>
            <div className = "answers">
                <div className = "answerItem">Answer1</div>
                <div className = "answerItem">Answer2</div>
                <div className = "answerItem">Answer3</div>
                <div className = "answerItem">Answer4</div>
            </div>
        </div>
    }
}