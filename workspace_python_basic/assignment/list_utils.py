def merge_lists(list1, list2):
    """두 개의 리스트를 병합하여 하나의 리스트로 반환합니다."""
    return list1 + list2

def minus_lists(list1, list2):
    """list1에서 list2와 공통 요소를 제거한 리스트를 반환"""
    return [item for item in list1 if item not in list2]
