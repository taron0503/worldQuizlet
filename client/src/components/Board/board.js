import { Component } from "react"
import axios from "axios";
import QuizCard from "../QuizCard/quizCard"
import "./style.css"

export default class Board extends Component{
    constructor(props) {
        super(props);
        this.state = {quizzes: null,
                      currentQuiz:0,
                      buttonText:"Start Quiz",
                      quizStatus:"notStarted",
                      answers:null};
    }

    async getQuizzes(){
        const response =
          await axios.post("http://localhost:8080/getQuestion")
          if(response)
            return response.data
    }

    async checkAnswers(){
        const response =
          await axios.post("http://localhost:8080/checkAnswers",this.state.quizzes)
          if(response)
            this.setState({answers:response.data,quizStatus:"finished",buttonText:"PLAY AGAIN"})
    }

    async startQuiz(){
        let quzziess = await this.getQuizzes();
        this.setState({...this.state,quizzes:quzziess,
                          currentQuiz:0,
                          quizStatus:"started",
                          buttonText:"NEXT",
                          answers:null})
    }

    nextQuestion(){
        if(this.state.currentQuiz == this.state.quizzes.length-1){
            this.checkAnswers();
            this.setState({buttonText:"PLAY AGAIN"})
            return;
        }
        this.setState((prevState,props)=>{
            if(this.state.currentQuiz == this.state.quizzes.length-2){
                return {currentQuiz:prevState.currentQuiz+1,buttonText:"FINISH"}
            }
            return {currentQuiz:prevState.currentQuiz+1} 
        })
    }

    onSelect = option=>{
        let quizzes = [...this.state.quizzes]
        if(quizzes[this.state.currentQuiz].answer==option)
            quizzes[this.state.currentQuiz].answer=null;
        else
            quizzes[this.state.currentQuiz].answer=option;
        this.setState({quizzes:quizzes});
    }

    render(){
        let quizzes = this.state.quizzes;
        let buttonText = this.state.buttonText;
        let quizStatus = this.state.quizStatus;
        let quiz;
        let score;
        if(quizzes)
           quiz = quizzes[this.state.currentQuiz]
        if(quizStatus === "finished"){
            let answers = this.state.answers;
            score = answers.filter(a=>a).length + "/" + answers.length;
        }

        let button =  <button type="button"  className={"btn btn-success btn-lg"}
           onClick={()=>this.startQuiz()}>{buttonText}</button>
        
        if(quizStatus=="started"){
           button =  <button type="button" 
           className={"btn btn-success btn-lg "+(!quiz.answer && " disabled")}
           onClick={()=>this.nextQuestion()}>{buttonText}</button>
        }

        return <div className="Board">
            <header className="Board-header">
                <p>WorldQuizlet</p>
                {quizStatus==="finished" && <div className="score">
                    <p>SCORE</p>
                    {score}</div>}
            </header>
            {quizStatus==="started"?<QuizCard quiz={quiz} onSelect={this.onSelect}/>:
            quizStatus==="finished" &&
                quizzes.map((q,i)=>{
                    if(this.state.answers[i])
                        return <QuizCard quiz={q} isCorrect={true} quizStatus={quizStatus}/>
                    return <QuizCard quiz={q} isCorrect={false} quizStatus={quizStatus}/>
                })}

            {button}
           
        </div>
        
    }
}