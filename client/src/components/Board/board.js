import { Component } from "react"
import axios from "axios";
import QuizCard from "../QuizCard/quizCard"
import "./style.css"

export default class Board extends Component{
    constructor(props) {
        super(props);
        this.state = {quizzes: null,currentQuiz:0};
    }

    async getDataAxios(){
        const response =
          await axios.post("http://localhost:8080/getQuestion")
          if(response)
        this.setState({...this.state,quizzes:response.data})
          
    }

    componentDidMount(){
        this.getDataAxios();
    }

    nextQuestion(){
        this.setState((prevState,props)=>{
            return {currentQuiz:prevState.currentQuiz+1} 
        })
    }

    onSelect = option=>{
        let quizzes = [...this.state.quizzes]
        if(quizzes[this.state.currentQuiz].answer)
            quizzes[this.state.currentQuiz].answer=null;
        else
            quizzes[this.state.currentQuiz].answer=option;
        this.setState({quizzes:quizzes});
    }

    render(){
        let quizzes = this.state.quizzes;
        let quiz;
        if(quizzes)
           quiz = quizzes[this.state.currentQuiz]
        return (quizzes && <div className="Board">
            <header className="Board-header">
                WorldQuizlet
                <QuizCard quiz={quiz} onSelect={this.onSelect}/>
            </header>
            <button type="button" 
                    className={"btn btn-success btn-lg "+(!quiz.answer && " disabled")}
                    onClick={()=>this.nextQuestion()}>Next</button>
        </div>)
    }
}