<template>
    <v-container>
            <v-form enctype="multipart/form-data" @submit.prevent="onBoardSubmit">
                <table>
                    <v-row justify="center">
                        <v-col cols="1" class="label">Title</v-col>
                        <v-col>
                            <v-combobox
                            class="titleFloat"
                                v-model="brackets"
                                :items="items"
                                label="말머리"
                                filled
                                style="width:130px; zoom:1"
                                outlined
                                dense
                                color="red darken-3"
                                ></v-combobox>
                            <v-text-field class="titleFloat" style="width:590px" color="red darken-3" v-model="title"/>
                        </v-col>
                    </v-row>
                    <v-row  wrap justify="center">
                        <v-col cols="2" class="label" > Content </v-col>
                        <v-col>
                        <input type="file" id="files" ref="files"  dense style="width:300px"
                                multiple v-on:change="handleFileUpload()"/>
                        </v-col>
                    </v-row>
                    <v-row justify="center">
                        <v-col cols="7">
                            <div class="notice">* 최대 5개의 이미지 등록 가능</div>
                        </v-col>
                    </v-row>
                    <v-row justify="center">
                        <v-col>
                        <div 
                            v-for="(file, index) in files" :key="index" style="text-align:center">
                            <p/>
                            <img :src=file.preview class="preview"/>
                            <p/>
                        </div>
                        </v-col>
                             <v-col cols="12">
                            <v-textarea style="white-space:pre-line" cols="70" rows="15" 
                            outlined color="red darken-3" placeholder="글을 작성해주세요"
                            v-model="content">
                            </v-textarea>
                        </v-col>
                    </v-row>
                 
                    <v-row wrap>
                        <v-btn @click="goPage" class="writeBtn" color="black" dark>cancle</v-btn>
                        <v-btn type="submit" class="writeBtn2" color="red darken-3" dark>write</v-btn>
                    </v-row>
                </table>
            </v-form>
    </v-container>
</template>

<script>

export default {
    name:'CommunityBoardWirte',
    data() {
        return {
            image :'',
            title:'',
            content:'',
            brackets: [],
            items: [
            '[전자기기]',
            '[서적]',
            '[프로젝트]',            
            ],
            files:[],
            filesPreview:[],
            response: ''
        }
    },
    created () {
        this.writer = this.$store.state.userInfo.name
    },
    methods: {
        handleFileUpload () {
             console.log(this.$refs.files.files)

            if(this.$refs.files.files.length > 5) {
                alert("선택할 수 있는 이미지 갯수를 초과하셨습니다.")
                document.getElementById("files").value = "";
                return 
            }else {
            for (let i = 0; i < this.$refs.files.files.length; i++){
                this.files = [
                    ...this.files,
                    {
                        file: this.$refs.files.files[i],
                        preview: URL.createObjectURL(this.$refs.files.files[i])
                    
                    }
                ]
            }

            console.log(this.files)

            }
        },
        onBoardSubmit () {

            const { title, writer, content, brackets} = this
            let formData = new FormData()

            for (let idx = 0; idx <  this.$refs.files.files.length; idx++) {
                  formData.append('file',this.$refs.files.files[idx])
            }

            formData.append('title',title)
            formData.append('writer', writer)
            formData.append('brackets', brackets)
            formData.append('content', content)
            
            this.$emit('submit', {formData})
            console.log(formData)

        },
        goPage (){
            this.$router.push('/review')
        }
    }

}
</script>
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap');

.label{
    margin-right:3%;
    text-align: center;
    padding-top: 10px;
    font-size:18pt;
    font-family: 'Noto Sans KR', sans-serif;
}
table{
    position: relative;
    background-color: rgb(245, 244, 244);
    padding-left: 10%;
    padding-right: 10%;
    padding-top: 5%;
    padding-bottom: 7%;
    margin-left:auto;
    margin-right:auto;
    zoom:90%;
}
.v-combobox, .v-text-field, .v-textarea, #files{
    font-family: 'Noto Sans KR', sans-serif;
}
.writeBtn {
    position: relative;
    margin-top:1.5%;
    zoom:1.3;
    float:left;
}
.writeBtn2 {
    position: absolute;
    zoom:1.3;
    margin-top:1.5%;
    margin-left:68%;
    float:left;
}
.titleFloat {
    float:left;
    margin-right:3%;
}
.preview {
    position: relative;
    margin-left: auto;
    margin-right:auto;
    max-width: 500px;
    max-height: 500px;
}
.notice {
    font-size: 10pt;
    font-family: 'Noto Sans KR', sans-serif;
    color: rgb(228, 23, 23);
}

@media (max-width:700px){
    table {
        zoom:60%;
        margin-bottom:30px;
    }
}
</style>