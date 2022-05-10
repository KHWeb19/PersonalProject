<template>
<div class="BG">
    <form @submit.prevent="onSubmit">
        <table>
            <tr>
                <td>
                    <input type="text" placeholder="제목" v-model="title"/>
                </td>
            </tr>
            <br>
            <tr>
                <td>
                    <input type="text" placeholder="작성자" v-model="writer"/>
                </td>
            </tr>
            <br>
            <tr>
            </tr>
        </table>
        <label>
            <input type="file" id="files" ref="files" 
                    multiple v-on:change="handleFileUpload()"/>
                    <button class="filebtn" v-on:click="submitFiles()">자료 업로드</button>
        </label>
        <br>
        

        <div class="btn">
            <button type="submit">등록</button>
            <router-link :to="{name: 'DataBoardListPage'}">
              <button class="backbtn"><i class="fas fa-arrow-left"></i></button>
            </router-link>
        </div>
        
    </form>
</div>
</template>

<script>

export default {
    name: 'DataBoardRegisterForm',
    data () {
        return {
            title : '',
            writer : ''
        }
    },
    methods: {
        onSubmit () {
            const { title, writer } = this
            this.$emit('submit', { title, writer })
        }
    }
}
</script>

<style scoped>
form {
margin-left: 600px;
}
input {
box-shadow: 0px -4px 10px rgba(255, 255, 255, 0.2), 0px 4px 6px #e8e8f3, inset 0px -4px 12px rgba(255, 255, 255, 0.6), inset 0px -2px 2px rgba(255, 255, 255, 0.2), inset 0px 4px 6px #c6c6e2;
padding: 1.75em;
height: 48px;
width: 500px;
border-radius: 100px;
background: transparent;
color: #6768ab;
text-shadow: 1px 1px rgba(255, 255, 255, 0.6);
resize: none;
}
input::placeholder {
color: #b6b6d9;
text-shadow: 1px 1px rgba(255, 255, 255, 0.6);
font-size: 14px;
}
textarea {
box-shadow: 0px -4px 10px rgba(255, 255, 255, 0.2), 0px 4px 6px #e8e8f3, inset 0px -4px 12px rgba(255, 255, 255, 0.6), inset 0px -2px 2px rgba(255, 255, 255, 0.2), inset 0px 4px 6px #c6c6e2;
padding: 1.75em;
height: 250px;
width: 500px;
border-radius: 50px;
background: transparent;
color: #6768ab;
text-shadow: 1px 1px rgba(255, 255, 255, 0.6);
resize: none;
}
textarea::placeholder {
color: #b6b6d9;
text-shadow: 1px 1px rgba(255, 255, 255, 0.6);
font-size: 14px;
}
button {
transition: box-shadow 0.3s ease, color 0.3s ease;
height: 48px;
width: 200px;
border-radius: 50em;
line-height: 48px;
color: #6768ab;
letter-spacing: 0.1em;
font-weight: bold;
cursor: pointer;
text-transform: uppercase;
text-shadow: 1px 1px rgba(255, 255, 255, 0.6);
margin: 0 1.5em;
margin-top: 50px;
padding: 0 3em;
box-shadow: -4px -4px 6px rgba(255, 255, 255, 0.7), 4px 4px 6px #c0c0de, inset -4px -4px 12px rgba(255, 255, 255, 0.1), inset 4px 4px 12px #e8e8f3;
}
[class*=button]:hover {
color: #6768ab;
}
button:hover {
box-shadow: -4px -4px 10px rgba(255, 255, 255, 0.2), 4px 4px 6px #e8e8f3, inset -4px -4px 12px rgba(255, 255, 255, 0.6), inset -2px -2px 2px rgba(255, 255, 255, 0.2), inset 4px 4px 6px #c6c6e2;
}
.backbtn:hover {
box-shadow: -4px -4px 10px rgba(255, 255, 255, 0.2), 4px 4px 6px #e8e8f3, inset -4px -4px 12px rgba(255, 255, 255, 0.6), inset -2px -2px 2px rgba(255, 255, 255, 0.2), inset 4px 4px 6px #c6c6e2;
}
</style>