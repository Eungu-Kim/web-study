// 이름 배열 (Java 코드와 동일)
const nameArray = [
    "강민형", "강은혜", "강주성", "고아라", "김규남", "김민석",
    "김우연", "김은수", "박달", "박자은", "서승아", "성원호",
    "신유진", "신혜지", "안태현", "엄희진", "이건", "이상민",
    "이슬기", "이영호", "이자영", "이주희", "임현섭", "전나영",
    "전정배", "차현수", "황정민"
];

// 조별 인원 수
const groupSizes = [5, 5, 5, 6, 6];

// 현재 선택된 조 ID
let selectedGroupId = null;

/**
 * 배열을 무작위로 섞는 함수 (Fisher-Yates 알고리즘)
 */
function shuffleArray(array) {
    const shuffled = [...array];
    for (let i = shuffled.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [shuffled[i], shuffled[j]] = [shuffled[j], shuffled[i]];
    }
    return shuffled;
}

/**
 * 조 편성을 생성하는 함수
 */
function createGroups() {
    const shuffledNames = shuffleArray(nameArray);
    const groups = [];
    let startIndex = 0;

    groupSizes.forEach((size, index) => {
        groups.push({
            id: index + 1,
            size: size,
            members: shuffledNames.slice(startIndex, startIndex + size)
        });
        startIndex += size;
    });

    return groups;
}

/**
 * 조를 화면에 렌더링하는 함수
 */
function renderGroups(groups) {
    const container = document.getElementById('groupsContainer');
    container.innerHTML = '';

    groups.forEach(group => {
        const card = document.createElement('div');
        card.className = 'group-card';
        card.dataset.groupId = group.id;
        card.onclick = () => toggleGroup(group.id);

        // 테이블 행 생성
        let membersHTML = '';
        group.members.forEach((member, index) => {
            membersHTML += `
                <tr>
                    <td class="member-number">${index + 1}</td>
                    <td class="member-name">${member}</td>
                </tr>
            `;
        });

        // 카드 내용 생성
        card.innerHTML = `
            <h2>${group.id}조 (${group.size}명)</h2>
            <table class="group-table">
                <tbody>
                    ${membersHTML}
                </tbody>
            </table>
        `;

        container.appendChild(card);
    });
}

/**
 * 조 선택/해제를 토글하는 함수
 */
function toggleGroup(groupId) {
    const cards = document.querySelectorAll('.group-card');
    const clickedCard = document.querySelector(`[data-group-id="${groupId}"]`);

    // 같은 조를 다시 클릭하면 선택 해제
    if (selectedGroupId === groupId) {
        selectedGroupId = null;
        clickedCard.classList.remove('selected');
    } else {
        // 다른 조가 선택되어 있으면 해제
        if (selectedGroupId !== null) {
            const prevCard = document.querySelector(`[data-group-id="${selectedGroupId}"]`);
            if (prevCard) {
                prevCard.classList.remove('selected');
            }
        }
        // 새로운 조 선택
        selectedGroupId = groupId;
        clickedCard.classList.add('selected');
    }
}

/**
 * Shuffle 버튼 클릭 시 실행되는 함수
 */
function shuffleGroups() {
    // 선택 초기화
    selectedGroupId = null;

    // 새로운 조 생성 및 렌더링
    const groups = createGroups();
    renderGroups(groups);

    console.log('조 편성이 완료되었습니다!');
}

/**
 * 페이지 로드 시 초기화
 */
window.onload = function() {
    // Shuffle 버튼 이벤트 리스너 등록
    const shuffleBtn = document.getElementById('shuffleBtn');
    shuffleBtn.addEventListener('click', shuffleGroups);

    // 초기 조 편성
    shuffleGroups();

    console.log('점심 메이트 추첨기가 준비되었습니다!');
};