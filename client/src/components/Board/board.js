import { Component } from "react"
import QuizCard from "../QuizCard/quizCard"
import "./style.css"

export default class Board extends Component{
    constructor(props) {
        super(props);
        this.state = {quizzes: []};
    }
    render(){
        return <div className="Board">
            <header className="Board-header">
                WorldQuizlet
                <QuizCard/>
            </header>
        </div>
    }
}