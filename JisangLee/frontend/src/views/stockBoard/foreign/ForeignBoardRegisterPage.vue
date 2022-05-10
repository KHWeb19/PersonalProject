<template>
<div align="center">
        <br><br>
        <span id="shadow" class="shadow">해외 주식 분석</span>
        <br><br>
        <foreign-board-register-form @submit="onSubmit"/>
</div>
</template>

<script>
import swal from 'sweetalert';
import ForeignBoardRegisterForm from '@/components/stockBoard/foreign/ForeignBoardRegisterForm.vue'
import axios from 'axios'

export default {
    name: 'ForeignBoardRegisterPage',
    components: {
        ForeignBoardRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { title, content, writer } = payload
            axios.post('http://localhost:7777/foreignboard/register', { title, writer, content })
                    .then(() => {
                        swal({                                                                              
                            text: "게시물이 등록되었습니다!",
                            icon: "success"
                            })
                            
                        this.$router.push({
                            name: 'ForeignBoardListPage'
                        })
                    })
                    .catch(() => {
                        alert('문제 발생!')
                    })
        }
    }
}
</script>