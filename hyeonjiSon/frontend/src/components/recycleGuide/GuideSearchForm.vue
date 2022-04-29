<template>
<div id="app">
  <v-app id="inspire">
    <v-container style="width:800px" justify="center">
    <v-card class="elevation-0" >
      <v-card-title>
        <v-spacer></v-spacer>
        <v-text-field
          v-model="search"
          label="Search"
          single-line
          hide-details
        ></v-text-field>
            <v-col cols="2" md="1">
                <v-btn id="searchBtn" dark small>
                    <v-icon>
                        mdi-magnify
                    </v-icon>
                </v-btn>
            </v-col>
      </v-card-title>
      <v-data-table
        :headers="headers"
        :items="desserts"
        :search="search"
      >
        <template v-slot:items="props">
          <td>{{ props.item.name }}</td>
          <td class="text-xs-right">{{ props.item.plastic }}</td>
          <td class="text-xs-right">{{ props.item.glass}}</td>
          <td class="text-xs-right">{{ props.item.vinyl }}</td>
          <td class="text-xs-right">{{ props.item.paper }}</td>
          <td class="text-xs-right">{{ props.item.can }}</td>
        </template>
        <template v-slot:no-results>
          <v-alert :value="true" color="error" icon="warning">
            찾으시는 제품 "{{ search }}" 의 정보를 찾을 수 없습니다.
          </v-alert>
        </template>
      </v-data-table>
    </v-card>
    </v-container>
  </v-app>
</div>
</template>

<script>
export default {
    name: "guideSearchForm.vue",
  data () {
    return {
      search: '',
      headers: [
        {
          text: '상품명',
          align: 'left',
          sortable: false,
          width: '200px',
          value: 'name'
        },
        { text: '플라스틱', value: 'plastic', sortable: false, width: '70px' },
        { text: '유리', value: 'glass', sortable: false, width: '60px' },
        { text: '비닐', value: 'vinyl', sortable: false, width: '60px' },
        { text: '종이', value: 'paper', sortable: false, width: '60px' },
        { text: '캔', value: 'can', sortable: false, width: '60px' }
      ],
      desserts: [
        {
          name: '제주 삼다수',
          plastic: '√',
          glass: '　',
          vinyl: '√',
          paper: '　',
          can: '　'
        },
        {
          name: '오뚜기 진라면매운컵',
          plastic: '　',
          glass: '　',
          vinyl: '√',
          paper: '√',
          can: '　'
        },
        {
          name: '오뚜기 사골곰탕국물',
          plastic: '　',
          glass: '　',
          vinyl: '√',
          paper: '　',
          can: '　'
        },
        {
          name: '팔도한끼 간편부대찌개',
          plastic: '√',
          glass: '　',
          vinyl: '√',
          paper: '　',
          can: '√'
        },
        {
          name: '코카콜라캔',
          plastic: '　',
          glass: '　',
          vinyl: '　',
          paper: '　',
          can: '√'
        },
        {
          name: '페리에 라임탄산병',
          plastic: '　',
          glass: '√',
          vinyl: '　',
          paper: '　',
          can: '√'
        },
        {
          name: '서울우유 살롱밀크티',
          plastic: '　',
          glass: '　',
          vinyl: '　',
          paper: '√',
          can: '　'
        },
        {
          name: '성창 투명비닐우산',
          plastic: '√',
          glass: '　',
          vinyl: '√',
          paper: '　',
          can: '√'
        },
        {
          name: '에프킬라 더블노즐',
          plastic: '√',
          glass: '　',
          vinyl: '　',
          paper: '　',
          can: '√'
        },
        {
          name: '깨끗한나라 물티슈30매',
          plastic: '　',
          glass: '　',
          vinyl: '√',
          paper: '　',
          can: '　'
        },
        {
          name: '성창 투명비닐우산',
          plastic: '√',
          glass: '　',
          vinyl: '√',
          paper: '　',
          can: '√'
        },
        {
          name: '페리오 듀얼클린칫솔2입',
          plastic: '√',
          glass: '　',
          vinyl: '　',
          paper: '√',
          can: '　'
        },
        {
          name: '미쟝센 퍼펙트 오리지널 헤어세럼',
          plastic: '√',
          glass: '　',
          vinyl: '　',
          paper: '　',
          can: '　'
        },
        {
          name: '삼립 피자호빵',
          plastic: '√',
          glass: '　',
          vinyl: '√',
          paper: '　',
          can: '　'
        },
        {
          name: '세양 미니언즈구운란 2구',
          plastic: '√',
          glass: '　',
          vinyl: '　',
          paper: '√',
          can: '　'
        },
        {
          name: '오뚜기 맛있는흑미밥210g',
          plastic: '√',
          glass: '　',
          vinyl: '√',
          paper: '　',
          can: '　'
        }
      ]
    }
  }
}
</script>

<style scoped>
.v-text-field >>> .v-input__slot::before  { 
  border-color: #ccbce3 !important;
  }
.v-text-field >>> .v-input__slot::after {
    border-color: #ccbce3 !important;
    }
    /* ↓안되네... */
.tr:hover{ 
    background-color: red;
}
.td {
  margin: 20px;
}
.btn-cover {
  margin-top: 1.5rem;
  text-align: center;
}
.btn-cover .page-btn {
  width: 5rem;
  height: 2rem;
  letter-spacing: 0.5px;
}
.btn-cover .page-count {
  padding: 0 1rem;
}

#searchBtn {
    background-color: darkkhaki;
    box-shadow: none;
}
</style>