<template >
    <div>
        <form @submit.prevent="onSubmit" class="reviewForm">
            <div v-if="checkuserInfo != null" class="showInputReview">
                <p>아이디 : {{id}}</p>
                <textarea type="text" v-model="content" placeholder="후기를 입력해주세요!" class="inputReview"/><br>
                <input type="file" id="files1" ref="files1"
                    multiple v-on:change="handleFileUpload()"/>
                <v-btn class="registerReview" type="submit" color="white">
                    <p>등록하기</p>
                </v-btn>
                <br><br><br>
            </div>
        </form>

    </div>
</template>

<script>
    export default {
        name:'ReviewPageForm',
        data() {
            return {
                checkuserInfo: window.localStorage.getItem('token'),
                id: (window.localStorage.getItem('id')),
                content:'',
               
            }
        },
        props: {
            reviews: {
                type: Array,
                required: true
            }
        },
        methods: {
            handleFileUpload() {
                this.files1 = this.$refs.files1.files
            },
            onSubmit() {
                const {id, content, files1} = this
                this.$emit('submit', {id, content, files1})
            },
            editItem(item){
                this.dialog = true, 
                this.modifyNo = item.reviewNo
                this.modifyContent = item.content
            },
            
        }
        
    }    
</script>

<style scoped>
.showInputReview{
    margin-bottom: 30px;
}
.inputReview {
    border: 2px solid rgb(37, 26, 26);
    width:700px;
    height: 100px;
    color:black;
}

.reviewForm {
    padding: 0 0 0 20%;
    
}

.registerReview{
    margin-left: 25%;
    margin-top: 5px;
}



.headline {
    height: 400px;
    width: 400px;
}

</style>