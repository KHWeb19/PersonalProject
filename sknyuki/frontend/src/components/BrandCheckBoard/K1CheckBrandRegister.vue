<template>
    <form @submit.prevent="onSubmit">

        <div class="app">
            <h3 style="padding:30px 0px 30px 0px; font-weight:bold" align="left">게시글 작성</h3>
            

            <h3 align="left">제목 : </h3>
            <input 
                type="text" 
                placeholder="내용을 입력하시오" 
                style="width:300px; font-size:20px;"
                v-model="title">
            

            <br>

            <h3 align="left">작성자 : </h3>
            <input
                type="text" width="300px"
                placeholder="내용을 입력하시오" 
                style="width:300px; font-size:20px;"
                v-model="writer">
           

            <br>

            <h3 align="left" >내용 : </h3>
            <textarea
                id="textarea-rows"
                placeholder="내용을 입력하시오"
                style="font-size:20px"
                rows="8" cols="100" v-model="content">
            </textarea>

            <div class="버튼" style="padding:20px;">
                <v-btn text color="black" rounded x-large
                    style="padding: 10px; width: 90px;" type="submit">등록하기
                </v-btn>

                <br>

                <router-link style="text-decoration: none; color:black" :to="{ name: 'K1CheckBrandView' }">
                    <v-btn text color="black" rounded x-large
                        style="padding: 10px; width: 90px;" type="submit">목록으로
                    </v-btn>
                </router-link>
            </div>
        </div>
        
        
    </form>
</template>

<script>
export default {
    name: 'BoardRegisterForm',
    data () {
        return {
            title: '',
            writer: '',
            content: ''
        }
    },
    methods: {
        onSubmit () {
            var result = confirm('등록 하시겠습니까?')
            if(result) {
                const { title, writer, content } = this
                this.$emit('submit', { title, writer, content })
            }
         }
    }
}
</script> 

<style scoped>
.app {
  padding:0px 200px 100px 200px;
}
</style>