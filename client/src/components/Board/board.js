import { Component } from "react"
import QuizCard from "../QuizCard/quizCard"
import "./style.css"

export default class Board extends Component{
    render(){
        return <div className="Board">
            <header className="Board-header">
                WorldQuizlet
                <QuizCard/>
            </header>
        </div>
    }
}