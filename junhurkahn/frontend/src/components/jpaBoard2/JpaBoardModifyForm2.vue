<template>
    <div>
        <form @submit.prevent="onSubmit">
            <table border="1">
                <tr>
                    <td>물건목록 수정하기</td>
                    <td>
                        <input type="text" :value="jpaBoard2.boardNo" disabled/>
                    </td>
                </tr>
                <tr>
                    <td>물건목록</td>
                    <td>
                        <input type="text" v-model="content"/>
                    </td>
                </tr>
                <tr>
                    <td>등록일자</td>
                    <td>
                        <input type="text" :value="jpaBoard2.regDate" disabled/>
                    </td>
                </tr>
                <tr>
                    <td>가게이름</td>
                    <td>
                        <textarea cols="50" rows="20" v-model="title">
                        </textarea>
                    </td>
                </tr>
            </table>

            <div>
                <button type="submit">수정 완료</button>
                <router-link :to="{ name: 'JpaBoardReadPage2',
                                    params: { boardNo: jpaBoard2.boardNo.toString() } }">
                    취소
                </router-link>
            </div>
        </form>
    </div>
</template>

<script>
export default {
    name: 'JpaBoardModifyForm2',
    props: {
        jpaBoard2: {
            type: Object,
            required: true
        }
    },
    data () {
        return {
            title: '',
          
            content: ''
        }
    },
    methods: {
        onSubmit () {
            const { title, content } = this
            this.$emit('submit', { title, content })
        }
    },
    created () {
        this.title = this.jpaBoard2.title
        this.content = this.jpaBoard2.content
        
    }
}
</script>