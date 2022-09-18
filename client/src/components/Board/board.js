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

    onSelect(option){
        console.log(this)
        // let quizzes = [...this.state.quizzes]
        // quizzes[this.state.currentQuiz].answer=option;
        // console.log(option)
        // this.setState({quizzes:quizzes});
    }

    render(){
        console.log(this.state)
        return <div className="Board">
            <header className="Board-header">
                WorldQuizlet
                {this.state.quizzes  && <QuizCard quiz={this.state.quizzes[this.state.currentQuiz]} onSelect={this.onSelect}/>}
            </header>
            <button type="button" className="btn btn-success btn-lg disabled" onClick={()=>this.nextQuestion()}>Next</button>
        </div>
    }
}