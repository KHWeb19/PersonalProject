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
                                style="width:100px; zoom:1"
                                outlined
                                dense
                                color="red darken-3"
                                ></v-combobox>
                            <v-text-field class="titleFloat" style="width:590px" color="red darken-3" v-model="title"/>
                        </v-col>
                    </v-row>
                    <v-row  wrap justify="center">
                        <v-col cols="1" class="label" > Files </v-col>
                        <v-col>
                        <input type="file" id="files" ref="files"  dense style="width:300px"
                                multiple v-on:change="handleFileUpload()"/>
                        </v-col>
                    </v-row>
                    <v-row justify="center">
                        <v-col cols="12">
                        <v-img :src="image" class="preview" alt=""/>
                        </v-col>
                    </v-row>
                    <v-row  justify="center">
                        <v-col cols="3" class="label" style="font-size:23pt">Content</v-col>
                        <v-col cols="12">
                            <v-textarea style="white-space:pre-line" cols="75" rows="15" 
                            outlined color="red darken-3" placeholder="글 내용을 작성해주세요"
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
            '[사담]',
            '[질문]'
            ],
            files:'',
            response: ''
        }
    },
    created () {
        this.writer = this.$store.state.userInfo.name
    },
    methods: {
        handleFileUpload () {
            console.log('이미지 첨부')

            var image = this.$refs['files'].files[0]
            const url = URL.createObjectURL(image)
            this.image = url

            this.files = this.$refs.files.files[0]
        },
        onBoardSubmit () {

            const { title, content,writer, brackets} = this
            const file =  this.$refs.files.files[0]
            
            this.$emit('submit', { title, content,writer, brackets, file })
            console.log(title,content,writer,brackets,file)

        },
        goPage (){
            this.$router.push('/community')
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
    max-height: 600px;
}

@media (max-width:700px){
    table {
        zoom:60%;
        margin-bottom:30px;
    }
}
</style>