<template>
    <v-container>
            <v-form enctype="multipart/form-data" @submit.prevent="onBoardSubmit">
                <table>
                    <v-row  wrap justify="center">
                        <p v-if="this.files.length == 0" class="beforeAttach" >
                                상품 이미지를 첨부해주세요.
                                <br/>
                                (450*450)
                                <br/>
                               <span style="color:red; font-size:10pt"> * 최대 5개의 이미지 등록 가능</span>
                        </p>
                        <v-carousel hide-delimiters  height="auto" v-else>
                            <v-carousel-item
                            v-for="(file, index) in files" :key="index" style="text-align:center">
                            <img :src=file.preview class="preview"/>
                            </v-carousel-item>
                        </v-carousel>
                    </v-row>
                    <v-row justify="center">
                        <v-col cols="3">
                            <input type="file" id="files" ref="files"  dense style="width:300px"
                                    multiple v-on:change="handleFileUpload()"/>
                        </v-col>
                    </v-row>
                     <v-divider/>
                    <v-row justify="start">
                        <v-col cols="1" class="label">Title</v-col>
                        <v-col>
                            <v-combobox
                            class="titleFloat"
                                v-model="category"
                                :items="items"
                                label="카테고리"
                                filled
                                style="width:130px; zoom:1"
                                outlined
                                dense
                                color="red darken-3"
                                ></v-combobox>
                            <v-text-field class="titleFloat" style="width:590px" color="red darken-3" v-model="title"/>
                        </v-col>
                    </v-row>
                    <v-row justify="start">
                        <v-col cols="1" class="label">Price</v-col>
                        <v-col>
                            <v-text-field class="price" outlined dense style="width:200px" color="red darken-3" v-model="price"/>
                        </v-col>
                    </v-row>
                    <v-row justify="start">
                        <v-col cols="3" class="label">Used Condition</v-col>
                        <v-col cols="8">
                            <v-chip dark :color="selectCondition.includes(item) ? 'red darken-3' : 'grey lighten-1'" @click="selectedCondition(item)" class="condition" v-model="usedCondition" v-for="(item, i) in condition" :key="i" >
                                {{item}}
                            </v-chip>
                            
                        </v-col>
                    </v-row>
                    <v-row justify="center" class="mt-7">
                             <v-col cols="12">
                            <v-textarea style="white-space:pre-line" cols="70" rows="15" 
                            outlined color="red darken-3" placeholder="상품을 소개해주세요"
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
    name:'MarketWirte',
    data() {
        return {
            image :'',
            title:'',
            content:'',
            category: [],
            price:'',
            usedCondition:[],
            items: [
            '[전자기기]',
            '[서적]',            
            ],
            condition: [
                '새 것','최상', '중상', '중', '중하',  '하'
            ],
            files:[],
            filesPreview:[],
            response: '',
            selectCondition:[]
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

            const { title, writer, content, category, price, usedCondition} = this
            let formData = new FormData()

            for (let idx = 0; idx <  this.$refs.files.files.length; idx++) {
                  formData.append('file',this.$refs.files.files[idx])
            }

            formData.append('title',title)
            formData.append('writer', writer)
            formData.append('category', category)
            formData.append('content', content)
            formData.append('price', price)
            formData.append('usedCondition', usedCondition)
            
            this.$emit('submit', {formData})
            console.log(formData)

        },
        goPage (){
            this.$router.push('/market')
        },
        selectedCondition (item) {
            if(this.usedCondition.length >0 && this.usedCondition != item ){
                alert("상품의 상태는 하나만 선택 가능합니다.")
                return false
            } 
                const el = this.selectCondition.findIndex(el => el === item);
                el < 0 ? this.selectCondition.push(item) : this.selectCondition.splice(el, 1);

                const el2 = this.usedCondition.findIndex(el2 => el2 === item);
                el2 < 0 ? this.usedCondition.push(item) : this.usedCondition.splice(el2,1) 
                console.log(this.usedCondition)
            
        },
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
.v-divider {
    margin-top:20px;
    margin-bottom:50px;
}
.condition {
    font-family: 'Noto Sans KR', sans-serif;
    margin-right:5%;
    zoom:130%;
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
.price {
    font-family: 'Noto Sans KR', sans-serif;
    font-size:15pt;
}
.preview {
    position: relative;
    margin-left: auto;
    margin-right:auto;
    max-width:450px;
    height:450px;
}
.beforeAttach {
    border: rgb(201, 199, 199) solid 2px;
    width:450px;
    height:450px;
    padding-top:24%;
    text-align: center;
    font-family: 'Noto Sans KR', sans-serif;
}

@media (max-width:700px){
    table {
        zoom:60%;
        margin-bottom:30px;
    }
}
</style>