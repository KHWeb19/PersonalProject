<template>
    <v-container class="container">
        <p class="createTitle">Create Post</p>
        <hr>
        <v-row justify="center">
            <v-col cols="12">
                <input type="text" v-model="title" placeholder="Title" class="inputTitle">
            </v-col>
        </v-row>

        <div class="buttonContainer">
            <button class="btn-editor" @click="btnBold"><font-awesome-icon icon="fa-solid fa-bold"/></button>
            <button class="btn-editor" @click="btnUnderline"><font-awesome-icon icon="fa-solid fa-underline" /></button>
            <button class="btn-editor" @click="btnItalic"><font-awesome-icon icon="fa-solid fa-italic" /></button>
            <button class="btn-editor" @click="btnStrike"><font-awesome-icon icon="fa-solid fa-strikethrough" /></button>
            <button class="btn-editor" @click="imgTesting"><font-awesome-icon icon="fa-solid fa-image" /></button>
        </div>

        <v-row justify="center">
            <v-col cols="12">
                <div contenteditable="true" id="divContent" @input="onInput" class="editor">
                    
                </div>
            </v-col>
            
                {{content}}

        </v-row>   

             <v-col>

                <input id="imgInput" type="file" multiple ref="files" accept="image/*" style="display: none">
            
                <v-btn @click="createPost">Create</v-btn>

             </v-col>
    </v-container>
</template>
<script>
import axios from 'axios'
import { PostUtility } from '@/javascript/postutility'
import {v4 as uuidv4} from 'uuid'

export default{
    
    data(){
        return{
            title: '',
            content: '',
            originalFiles: [],
            previews: [],
            strUUID: ''
        }
    },
    watch: {
        content:{
            handler(newVal, oldVal){
                if (newVal.length <= oldVal.length)
                    this.consistent()
            }
        }
    },
    methods: {
        btnBold(){
            document.execCommand('bold')
        },
        btnUnderline(){
            document.execCommand('underline')
        },
        btnItalic(){
            document.execCommand('italic')
        },
        btnStrike(){
            document.execCommand('strikeThrough')
            uuidv4()
        },
        consistent(){
            this.previews.forEach(item => {
                if(!this.content.includes(item)){
                    this.previews.splice(this.previews.indexOf(item))
                }
            })
        }
        ,
        imgTesting(){
            const imgInput = document.getElementById("imgInput")
            imgInput.click()

        },
        onInput(e){
            this.content = e.target.innerHTML
        },

        replaceImages(){

            this.strUUID = uuidv4()
            console.log(this.strUUID)
            this.previews.forEach(() => {
                let startIdx = this.content.indexOf("<img src=\"")
                let endIdx = this.content.indexOf("\">")
                let strToReplace = this.content.substring(startIdx,endIdx+2)
                this.content = this.content.replace(strToReplace, this.strUUID)

            })
            
            console.log(this.content)
            
            
        },

        createPost(){
            let formData = new FormData()

            for (let i = 0; i<this.originalFiles.length; i++){
                formData.append('fileList', this.originalFiles[i])
            }

            this.replaceImages()

            const {title, content} = this
            const fileinfo = {title, content}


            formData.append("info", new Blob([JSON.stringify(fileinfo)], {type: "application/json"}))
            formData.append("strUUID" , this.strUUID)            

            axios.post('freepost/create', formData)
            .then(
                this.$router.push("/")
            )
            .catch(() =>alert("Failed Creating Post"))
        }
       
    },
    mounted(){
        document.getElementById("imgInput").addEventListener('change',
         (e) => {
            let files = e.target.files
            let promises = []
            if(!files.length) return

            for (let i=0; i<files.length; i++){
                this.originalFiles.push(files[i])
                promises.push(PostUtility.readFile(files[i]))
            }

            Promise.all(promises).then((values) => {
                values.forEach((item) => {
                    document.getElementById('divContent').focus({preventScroll: true})
                    document.execCommand('insertImage', false, item)
                    this.previews.push(item)})
            })
         })
    }
}
</script>

<style scoped>
    .container{
        margin: 20px 0 10px 0;
        padding: 10px;
        box-shadow: 0 3px 10px rgb(0 0 0 / 0.2);
    }
    
    .createTitle{
        font-size: 30px;
        font-weight: bold;
        margin: 4px;
        padding: 4px;
    }

    .inputTitle{
        width: 70%;
        margin: 30px 4px 10px 4px;
        padding: 4px;
        font-size: 20px;
    }

    .buttonContainer{
        display:flex;
        justify-content: flex-start;
    }

    .btn-editor{
        margin: 10px;
        width: 50px;
        height: 100%;
    }

    #divContent{
        width: 100%;
        margin: 8px 4px 4px 4px;
        font-size: 18px;
        padding: 4px;
        min-height: 500px;
        box-shadow: 0 0 5px 0 rgba(0,0,0,0.5);
    }

    #divContent img{
        width: 200px;
        height: 200px;
    }
</style>



