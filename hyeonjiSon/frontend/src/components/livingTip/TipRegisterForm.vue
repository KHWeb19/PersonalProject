<template>
    <form @submit.prevent="onSubmit">
        <table>
            <tr>
                <td>제목</td>
                <td>
                    <input type="text" v-model="title" placeholder=" *필수 입력"/>
                </td>
            </tr>
            <tr>
                <td>작성자</td>
                <td>
                    <input type="text" v-model="writer" placeholder=" *필수 입력"/>
                </td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td>
                    <input type="text" v-model="password" placeholder=" *필수 입력"/>
                </td>
            </tr>
            <tr>
                <td>본문</td>
                <td>
                    <textarea cols="50" rows="20" v-model="content" placeholder=" *내용을 작성해주세요.">
                    </textarea>
                </td>
            </tr>
        </table>

        <div>
            <button type="submit">등록</button>
            <router-link :to="{ name: 'livingTipBoardList' }">
                취소
            </router-link>
        </div>
    </form>
</template>

<script>
export default {
    name: 'TipRegisterForm',
    methods: {
        onSubmit () {
            const {title, writer, password, content} = this
            this.$emit('submit', {title, writer, content, password})
        }
    }
    
}
</script>


<style scoped>
tr {
    height: 50px;
}
</style>