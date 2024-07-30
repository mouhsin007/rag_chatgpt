import {Button, TextField} from "@vaadin/react-components";
import {useState} from "react";
import {ChatAiService} from "Frontend/generated/endpoints";
import Markdown from "react-markdown";

export default function Chat(){
    const [question,setQuestion]= useState<string>("");
    const [response,setResponse]= useState<string>("");
    async function send(){
        ChatAiService.ask(question).then(res=>{
            setResponse(res);
        })
    }

    return(
        <div className="p-m">
            <h1>Chat bot</h1>
            <TextField style={{width:'80%'}} onChange={(e=>setQuestion(e.target.value))}/>
            <Button theme="primary" onClick={send}>Send</Button>
            <Markdown>
                {response}
            </Markdown>
        </div>
    );
}